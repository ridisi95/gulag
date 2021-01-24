import { delay, put, takeLatest } from '@redux-saga/core/effects';
import { START_LOGIN } from 'store/actions/login/config';
import { fakeLoginAction } from 'store/actions/login';

function* loginSaga() {
  yield delay(2000);
  yield put(fakeLoginAction());
}

export function* authenticationSaga() {
  yield takeLatest(START_LOGIN, loginSaga);
}
