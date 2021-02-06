import styled from 'styled-components';
import { devices } from 'src/config/styles/breakpoints/indes';

export const HomeSliderWrapper = styled.div`
  margin: 0 auto;
  width: 100%;

  @media ${devices.tabletLandscape} {
    width: 960px;
  }
`;

export const SliderImageWrapper = styled.div`
  margin: 0 auto;
  width: 100%;
`;
