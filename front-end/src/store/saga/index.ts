import { fork } from '@redux-saga/core/effects';
import { authenticationSaga } from 'store/saga/authentication';

export function* rootSaga() {
  yield fork(authenticationSaga);
}
