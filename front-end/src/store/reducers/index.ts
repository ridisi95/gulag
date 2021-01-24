import { combineReducers } from 'redux';
import { login } from 'store/reducers/authentication';

export const rootReducer = combineReducers({
  login,
});
