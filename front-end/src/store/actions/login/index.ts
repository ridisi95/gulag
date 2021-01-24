import { FAKE_LOGIN, START_LOGIN } from 'store/actions/login/config';

export const fakeLoginAction = () => ({
  type: FAKE_LOGIN,
});

export const startLoginAction = () => ({
  type: START_LOGIN,
});
