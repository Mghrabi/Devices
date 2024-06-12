# app.py
import json
from flask import Flask, request, jsonify
import pandas as pd
from src.run_model import Model

app = Flask(__name__)
model = Model()
@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    data = pd.DataFrame([data])
    columns = data.columns
    if 'price_range' in columns:
        data = data.drop('price_range', axis=1)
    
    if 'id' in columns:
        data = data.drop('id', axis=1)
    print(data)
    data = data[['battery_power', 'blue', 'clock_speed', 'dual_sim', 'fc', 'four_g',
       'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height',
       'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time', 'three_g',
       'touch_screen', 'wifi']]
    pred = model(data)
    return jsonify({'price_range': pred.tolist()})


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
