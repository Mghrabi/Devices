import os
import pandas as pd
from run_model import Model
current_dir = os.path.dirname(os.path.abspath(__file__))
csv_test_path = os.path.join(current_dir, '../data/test.csv')

X_test = pd.read_csv(csv_test_path)
X_test.drop(columns=['id'], inplace=True)

model = Model()
print(model(X_test))