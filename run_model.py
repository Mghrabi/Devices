import pandas as pd
import numpy as np

from sklearn.preprocessing import StandardScaler 
from sklearn.model_selection import train_test_split
from sklearn.model_selection import StratifiedKFold, KFold
from sklearn.linear_model import SGDClassifier, LogisticRegression
from sklearn.ensemble import VotingClassifier
from joblib import dump, load


from sklearn.ensemble import RandomForestClassifier
from sklearn.svm import SVC
from xgboost import XGBClassifier

from sklearn.metrics import accuracy_score, confusion_matrix

import matplotlib.pyplot as plt
import seaborn as sns


X_train = pd.read_csv('../data/train - train.csv')
# X_test = pd.read_csv('../data/test - test.csv')
# X_test.drop(columns=['id'], inplace=True)
remove_feat = []
X_train.drop(columns= remove_feat, inplace=True)


def normalize(df):
    feat = ['battery_power','clock_speed', 'fc', 'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height', 'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time']
    feat = [f for f in feat if f not in remove_feat]
    scaler = StandardScaler()
    df[feat] = scaler.fit_transform(df[feat])
    return df

def fill_missing_values(df):
    feat_mean = ['battery_power','clock_speed', 'fc', 'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height', 'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time']
    feat_mode = ['blue', 'dual_sim', 'four_g', 'three_g', 'touch_screen', 'wifi']
    feat_mean = [f for f in feat_mean if f not in remove_feat]
    feat_mode = [f for f in feat_mode if f not in remove_feat]
    # filling missing values based on X_train (in production time, could be on the entire dataset instead of X_train, but not a big deal anyway)
    means = X_train[feat_mean].mean().to_dict()
    modes = X_train[feat_mode].mode().iloc[0].to_dict()
    
    df.fillna(means, inplace=True)
    df.fillna(modes, inplace=True)
    return df

def prepare_data(data):
    data = normalize(data)
    data = fill_missing_values(data)
    return data

def model(x):
    # data preprocessing 
    x = prepare_data(x)
    
    #load models
    folds = []
    for i in range(5):
        folds.append(load('./models/'+'model_'+str(i)+'.joblib'))
        
    #predictions 
    all_preds = []
    for model in folds:
        pred = model.predict(x)
        all_preds.append(pred)
    y_pred = np.rint(np.mean(all_preds, axis=0))
    return y_pred