const breakpoints = {
  xs: '568px',
  sm: '758px',
  m: '1024px',
  l: '1366px',
  xl: '1680px',
} as const;

export const devices = {
  mobileLandscape: `(min-width: ${breakpoints.xs})`,
  tabletPortrait: `(min-width: ${breakpoints.sm})`,
  tabletLandscape: `(min-width: ${breakpoints.m})`,
  laptop: `(min-width: ${breakpoints.l})`,
  desktop: `(min-width: ${breakpoints.xl})`,
} as const;
