import createSagaMiddleware from 'redux-saga';
import { applyMiddleware, createStore, Store } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { isDevelopment } from 'utils/env';
import { rootSaga } from 'store/saga';
import { rootReducer } from 'store/reducers';

export const initStore = (): Store => {
  const sagaMiddleware = createSagaMiddleware();
  const allMiddleware = [sagaMiddleware];
  const middlewareEnhancer = applyMiddleware(...allMiddleware);
  const enhancers = [middlewareEnhancer];

  // Show devtools only when development
  const composeEnhancer = isDevelopment()
    ? composeWithDevTools(...enhancers)
    : middlewareEnhancer;

  // start saga

  const store = createStore(rootReducer, composeEnhancer);
  sagaMiddleware.run(rootSaga);

  return store;
};
