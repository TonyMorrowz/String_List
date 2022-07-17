package com.example.stringlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

    class StringViewModel(application: Application): AndroidViewModel(application) {

            val readAllData: LiveData<List<StringItem>>
            private val repository: StringRepository

            init {
                val stringDAO = StringDatabase.getDatabase(
                    application
                ).stringDAO()
                repository = StringRepository(stringDAO)
                readAllData = repository.readAllData
            }

            fun addString(stringItem: StringItem){
                viewModelScope.launch(Dispatchers.IO) {
                    repository.addString(stringItem)
                }
            }

            fun updateString(stringItem: StringItem){
                viewModelScope.launch(Dispatchers.IO) {
                    repository.updateString(stringItem)
                }
            }

            fun deleteString(stringItem: StringItem){
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteString(stringItem)
                }
            }

            fun deleteAllStrings(){
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteAllStrings()
                }
            }

        }
