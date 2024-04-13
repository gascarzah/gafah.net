import { configureStore } from '@reduxjs/toolkit'
import languageReducer from "./slice/languageSlice";

export const store = configureStore({
  reducer: {
    language: languageReducer
  },
})