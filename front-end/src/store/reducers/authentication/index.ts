import {
  FAKE_LOGIN,
  INITIAL_STATE,
  START_LOGIN,
} from 'store/actions/login/config';

export const login = (state = INITIAL_STATE, action) => {
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
