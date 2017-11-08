from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation
from keras.optimizers import SGD
from keras import backend as K
import numpy as np
from sklearn.preprocessing import MinMaxScaler

X = []
y = []

x_scaler = MinMaxScaler()
y_scaler = MinMaxScaler()

import csv
import sys

filename = sys.argv[1]

with open(filename) as csvfile:
    readCSV = csv.reader(csvfile, delimiter=',')
    for row in readCSV:
        X.append([int(row[1]),int(row[2])])
        y.append([float(row[3])])
X = np.array(X)
y = np.array(y)
X = x_scaler.fit_transform(X)
y = y_scaler.fit_transform(y)

model = Sequential()
model.add(Dense(1024, input_dim=2))
model.add(Activation(K.relu))
model.add(Dense(512,  activation='relu'))
model.add(Dense(256,   activation='relu'))
model.add(Dense(128,  activation='relu'))
model.add(Dense(1, activation='linear'))

sgd = SGD(lr=0.1)
model.compile(loss='mse', optimizer='adam', metrics=['mae'])

model.fit(X, y, batch_size=100, epochs=10)

res = model.predict(X, batch_size=32)
res_rscl = y_scaler.inverse_transform(res)

Y_rscl = y_scaler.inverse_transform(y)

file = open('predict.csv', 'w')
for var in res_rscl:
    file.write(var)

