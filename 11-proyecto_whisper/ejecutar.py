# import logging
from pathlib import Path
import os
import whisper
# from concurrent.futures import ThreadPoolExecutor
from multiprocessing.pool import ThreadPool
import json
from pymongo import MongoClient
from pydub import AudioSegment
import time

path = "D:\\audios\\"
def main():
    # strStart = "%.2f" % time.perf_counter()
    # start = float(strStart)
    # print(start)

    # time.sleep(2)
    # strEnd = "%.2f" % time.perf_counter()
    # end = float(strEnd)    
    # print(end)
    
    # result = end - start
    # strResult = "%.2f" % result
    # print(strResult)

    entries = os.listdir(path)

    with ThreadPool() as pool:
        pool.map(leerArchivo, entries)
        # for result in pool.map(leerArchivo, entries):
        # report the value to show progress
            # print('')



def leerArchivo(nombreArchivo):

    pathAudio=str(path+nombreArchivo)
    print(pathAudio)
    myList = []
    try:
        strStart = "%.2f" % time.perf_counter()
        start = float(strStart)
        sStart = "%.2f" % start
        print(type(sStart))
        print(sStart)

        model = whisper.load_model("medium")
        result =model.transcribe(pathAudio)
        
        duration = get_duration_pydub(pathAudio) 
        
        strEnd = "%.2f" % time.perf_counter()
        end = float(strEnd)    
        sEnd = "%.2f" % end
        print(sEnd)
        
        resultado = end - start
        strFinal = "%.2f" % resultado
        # print(strResult)
        # strResult = '{"archivo" : "' + nombreArchivo + '", "duracion_audio" : "'+ "99"  + '", "text" : "' + "hola"  + '", "tiempo_inicio_proceso " : "'+ str(start) + '", "tiempo_fin_proceso" : "' + str(end)  + '", "tiempo_transcurrido " : "'+ str(result) + '" }'
        strResult = '{"archivo" : "' + nombreArchivo + '", "duracion_audio" : "'+ "{:.2f}".format(duration)  + '", "text" : "' + result['text']  + '", "tiempo_inicio_proceso " : "'+ sStart + '", "tiempo_fin_proceso" : "' + sEnd  + '", "tiempo_transcurrido " : "'+ strFinal + '", "fecha" : "'+ time.strftime("%d/%m/%y %H:%M:%S") + '" }'
        jsonResult = json.loads(strResult)
        myList.append(jsonResult)

    except Exception as e:
        print(e)
    
    guardarResultado(myList)


def get_duration_pydub(file_path):
   audio_file = AudioSegment.from_file(file_path)
   duration = audio_file.duration_seconds
   return duration

def guardarResultado(myList):
    client = MongoClient('localhost',
                    port=27017,
                    username='',
                    password='')
    db = client['noticias']
    col = db['audio-texto']
    col.insert_many(myList)
    
    client.close()





main()