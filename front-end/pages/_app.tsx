import React, { ReactElement } from 'react';
import { Provider } from 'react-redux';
import { AppProps } from 'next/app';
import 'styles/globals.css';
import { initStore } from 'store/init';

const store = initStore();

function MyApp({ Component, pageProps }: AppProps): ReactElement {
  return (
    <Provider store={store}>
      <Component {...pageProps} />
    </Provider>
  );
}

export default MyApp;
