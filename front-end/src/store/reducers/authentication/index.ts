import {
  FAKE_LOGIN,
  INITIAL_STATE,
  START_LOGIN,
} from 'store/actions/login/config';
import { ActionType } from 'models//store/actions';

export const login = (state = INITIAL_STATE, action: ActionType<void>) => {
  switch (action.type) {
    case FAKE_LOGIN:
      return {
        ...state,
        authenticated: true,
        loading: false,
      };
    case START_LOGIN:
      return {
        ...state,
        loading: true,
      };
    default:
      return state;
  }
};
