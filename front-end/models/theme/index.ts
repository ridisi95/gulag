/**
 * COLORS
 * */
type COLORS_NAMES = 'warning' | 'blue' | 'lightBlue' | 'white';
type COLORS_VALUES = 'rgb(255, 85, 0)' | '#2a88c7' | '#2a88c7' | '#fff';

export type COLORS = Record<COLORS_NAMES, COLORS_VALUES>;

/**
 * TRANSITION
 * */

type TRANSITION_NAMES = 'short' | 'standard';
type TRANSITION_VALUES = '.5s ease' | '1s ease';

export type TRANSITION = Record<TRANSITION_NAMES, TRANSITION_VALUES>;

/**
 * FONT-SIZES
 * */

type FS_NAMES = 'xxl' | 'xl' | 'l' | 'm' | 'sm' | 'xs' | 'xxs';
type FS_VALUES_MOBILE =
  | '38px'
  | '36px'
  | '30px'
  | '24px'
  | '18px'
  | '16px'
  | '14px';
type FS_VALUES_DESKTOP =
  | '45px'
  | '40px'
  | '20px'
  | '23px'
  | '18px'
  | '14px'
  | '10px';

type FS_MOBILE = Record<FS_NAMES, FS_VALUES_MOBILE>;
type FS_DESKTOP = Record<FS_NAMES, FS_VALUES_DESKTOP>;

export type FONT_SIZES = {
  mobile: Readonly<FS_MOBILE>;
  desktop: Readonly<FS_DESKTOP>;
};
