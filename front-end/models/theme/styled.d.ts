import {} from 'styled-components';
import { THEME_TYPE } from 'models//theme/index';

declare module 'styled-components' {
  // eslint-disable-next-line @typescript-eslint/no-empty-interface
  export interface DefaultTheme extends THEME_TYPE {} // extends the global DefaultTheme with our ThemeType.
}
