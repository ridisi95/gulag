import { FlattenSimpleInterpolation } from 'styled-components';
import { theme } from 'src/config/theme';
/**
 * FONT-FAMILIES
 * */

type FF_NAMES = 'regular' | 'bold' | 'interactive';

export type FONT_FAMILY = Record<FF_NAMES, FlattenSimpleInterpolation>;

export type THEME_TYPE = typeof theme;
