import { ReactElement, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import Head from 'next/head';
import styles from 'styles/Home.module.css';
import { startLoginAction } from 'store/actions/login';
import useTranslation from 'next-translate/useTranslation';
import { LOCALES } from 'src/config/locales';
import Link from 'next/link';
import { useRouter } from 'next/router';
import { useSelectorTyped } from 'store/index';

export default function Home(): ReactElement {
  const dispatch = useDispatch();
  const { t } = useTranslation('common');
  const router = useRouter();

  const isAuthenticated = useSelectorTyped(state => state.login.authenticated);
  const loading = useSelectorTyped(state => state.login.loading);

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
            {t('test')}
          </button>
        )}

        {LOCALES.map(locale => (
          <Link key={locale} href={router.asPath} locale={locale}>
            <a>{locale}</a>
          </Link>
        ))}
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
