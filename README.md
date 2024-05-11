# Two Application sub-projects 
* Python: contain the AI model (project completed before deadline, can check commits time, few refactoring were done after deadline)
* java backend (springboot): incomplete as deadline has passed

# Guide To Run Trained model 
* Model small description: prediction consists of 5 different model folds (each trained on a different subset of the train data), each fold is an ensemble of 4 different models (svm, log_reg, xgb, rf)

* `./src/EDA_&_Model_Train.ipynb`: has EDA and train/eval pipelines

* `./src/run_model.py`: contain the model (ready for inference), the model weights is included in the repo (as they are too small in size), means the model is ready for run once all required packages installed

* `test_model.py`: can be run directly and see model predictions on `test.csv` file provided

* `test_model.ipynb` jupyter notebook version of `test_model.py`

## Install Packages 
To run this application, make sure you have Python installed. You can then install the required packages using the `requirements.txt` file provided. 

```bash
pip install -r requirements.txt
```

## Run The Model (example provided)
* Open `src/test_model.ipynb` and run model



# Backend Application:
* (wasn't uploaded as deadline passed)
