import React, { ReactElement } from 'react';
import { ThemeProvider } from 'styled-components';
import { Provider } from 'react-redux';
import { AppProps } from 'next/app';
import { initStore } from 'store/init';
import { theme } from 'src/config/theme';
import { GlobalStyle } from 'src/config/styles/indext';

const store = initStore();

function MyApp({ Component, pageProps }: AppProps): ReactElement {
  return (
    <Provider store={store}>
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Component {...pageProps} />
      </ThemeProvider>
    </Provider>
  );
}

export default MyApp;
