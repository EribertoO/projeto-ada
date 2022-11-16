"""# Import Libraries"""
import os
os.system('cls||clear')

import edgel3
import soundfile as sf
import numpy as np
import os
import random
import sys
import glob 
from tqdm import tqdm
import warnings
warnings.filterwarnings('ignore')

#model = edgel3.models.load_embedding_model(model_type='sparse', emb_dim=256,  retrain_type='ft', sparsity=53.5 )
model = edgel3.models.load_embedding_model(model_type='sparse', emb_dim=256, retrain_type='kd', sparsity = 87.0 )

def extract_feature2(file_name):

    """Function Extracts Features from WAV file"""
    #X, sample_rate = librosa.load(file_name)
    X, sample_rate  = sf.read(file_name)
    #emb, ts = edgel3.get_embedding(X, sample_rate)
    emb, ts = edgel3.get_embedding(X, sample_rate, model=model)
    result = np.mean(emb.T,axis=1).T
    

    return emb

def extract_feature(file_name):
    """Function Extracts Features from WAV file"""

    X, sample_rate = librosa.load(file_name)

    stft = np.abs(librosa.stft(X))
    result = np.array([])
    mfccs = np.mean(librosa.feature.mfcc(y=X, sr=sample_rate, n_mfcc=40).T,axis=0)
    result = np.hstack((result, mfccs))
    chroma = np.mean(librosa.feature.chroma_stft(S=stft, sr=sample_rate).T,axis=0)
    result = np.hstack((result, chroma))
    mel = np.mean(librosa.feature.melspectrogram(X, sr=sample_rate).T,axis=0)
    result = np.hstack((result, mel))
    return result

"""#### Dictionary of Emotions and Function to Append Gender"""

emotions={
  '01':'neutral',
  '02':'calm',
  '03':'happy',
  '04':'sad',
  '05':'angry',
  '06':'fearful',
  '07':'disgust',
  '08':'surprised'
}

def gender(g):
    """Returns Gender Label"""
    if int(g[0:2]) % 2 == 0:
        return 'female'
    else:
        return 'male'

"""### Function to Load and Label Data"""

def load_data(test_size=0.2):
    """Loads Data from directory containing WAV files."""
    x,y=[],[]
    for file in tqdm(glob.glob("data_w_song//Actor_*//*.wav")):
        file_name=os.path.basename(file)
        emotion=emotions[file_name.split("-")[2]] + '_' + gender(file_name.split("-")[-1])
        feature=extract_feature2(file)
        x.append(feature)
        y.append(emotion)
        os.system('cls||clear')
    return train_test_split(np.array(x), y, test_size=test_size, random_state=9)

"""## Split Data"""

X_train, X_test, y_train, y_test = load_data()

print((X_train.shape[0], X_test.shape[0]))

print(f'Features extracted: {X_train.shape[1]}')

#X_train[0]

np.savez_compressed('train_test.npz', a=X_train, b=X_test, c=y_train, d=y_test)
