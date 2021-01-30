import { colors } from 'src/config/theme/colors';
import { transitions } from 'src/config/theme/transition';
import { fontFamily, fontSizes } from 'src/config/theme/fonts';

export const theme = {
  colors,
  transitions,
  typography: {
    fontSizes,
    fontFamily,
  },
} as const;
