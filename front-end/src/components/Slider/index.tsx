import React from 'react';
import { SliderWrapper } from 'components/Slider/style';
import dynamic from 'next/dynamic';
import { Settings } from 'react-slick';
import { NoSSR } from 'src/wrappers/NoSSR';
import { Arrow } from 'components/Slider/Arrow/style';

const Slider = dynamic(() => import('react-slick'), { ssr: false });

export type GulagSliderProps = Settings;

export const GulagSlider: React.FC<GulagSliderProps> = ({
  dots = true,
  slidesToScroll = 1,
  speed = 1000,
  slidesToShow = 1,
  infinite = true,
  children,
  autoplay = true,
  autoplaySpeed = 3000,
}) => (
  <NoSSR>
    <SliderWrapper>
      <Slider
        autoplaySpeed={autoplaySpeed}
        dots={dots}
        autoplay={autoplay}
        slidesToScroll={slidesToScroll}
        speed={speed}
        slidesToShow={slidesToShow}
        infinite={infinite}
        nextArrow={<Arrow arrowType="next" />}
        prevArrow={<Arrow arrowType="prev" />}
      >
        {children}
      </Slider>
    </SliderWrapper>
  </NoSSR>
);
