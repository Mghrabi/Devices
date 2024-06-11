import pandas as pd
from run_model import Model

X_test = pd.read_csv('../data/test.csv')
X_test.drop(columns=['id'], inplace=True)

model = Model()
model(X_test)