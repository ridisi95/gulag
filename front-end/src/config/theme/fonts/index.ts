import { FONT_FAMILY } from 'models//theme';
import { css } from 'styled-components';

export const fontSizes = {
  desktop: {
    xxl: '45px',
    xl: '40px',
    l: '23px',
    m: '20px',
    sm: '18px',
    xs: '14px',
    xxs: '10px',
  },
  mobile: {
    xxl: '38px',
    xl: '36px',
    l: '30px',
    m: '24px',
    sm: '18px',
    xs: '16px',
    xxs: '14px',
  },
};

export const fontFamily: FONT_FAMILY = {
  regular: css`
    font-family: 'Play', sans-serif;
    font-weight: 400;
  `,
  bold: css`
    font-family: 'Play', sans-serif;
    font-weight: 700;
  `,
  interactive: css`
    font-family: 'Hanalei Fill', cursive;
    font-weight: 400;
  `,
};
