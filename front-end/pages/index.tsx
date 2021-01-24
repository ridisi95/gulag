import { ReactElement, useCallback } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Head from 'next/head';
import styles from 'styles/Home.module.css';
import { startLoginAction } from 'store/actions/login';

export default function Home(): ReactElement {
  const dispatch = useDispatch();

  const isAuthenticated = useSelector(state => state.login.authenticated);
  const loading = useSelector(state => state.login.loading);

  const login = useCallback(() => {
    dispatch(startLoginAction());
  }, [dispatch]);

  return (
    <div className={styles.container}>
      <Head>
        <title>Create Next App</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      {loading && <span>LOADING</span>}

      <main className={styles.main}>
        {isAuthenticated ? (
          <span>Authenticated</span>
        ) : (
          <button type="button" onClick={login}>
            Login
          </button>
        )}
      </main>

      <footer className={styles.footer}>
        <a
          href="https://vercel.com?utm_source=create-next-app&utm_medium=default-template&utm_campaign=create-next-app"
          target="_blank"
          rel="noopener noreferrer"
        >
          Powered by{' '}
          <img src="/vercel.svg" alt="Vercel Logo" className={styles.logo} />
        </a>
      </footer>
    </div>
  );
}
