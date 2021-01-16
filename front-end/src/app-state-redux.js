import {combineReducers} from "redux";
import {header} from './headers/redux/header-reducers'
import {main_page} from "./pages/MainPage/redux/main_page_reducers";

// combine all individual reducers into a single reducer
export const combined_reducer = combineReducers(
    {
        header,
        main_page
    }
)