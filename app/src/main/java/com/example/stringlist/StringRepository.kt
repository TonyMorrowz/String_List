package com.example.stringlist

import androidx.lifecycle.LiveData


class StringRepository(private val stringDAO: StringDAO) {

        val readAllData: LiveData<List<StringItem>> = stringDAO.readAllData()

        suspend fun addString(stringItem: StringItem){
            stringDAO.addString(stringItem)
        }

        suspend fun updateString(stringItem: StringItem){
            stringDAO.updateString(stringItem)
        }

        suspend fun deleteString(stringItem: StringItem){
            stringDAO.deleteString(stringItem)
        }

        suspend fun deleteAllStrings(){
            stringDAO.deleteAllStrings()
        }

    }
