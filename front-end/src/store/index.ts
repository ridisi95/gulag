import { TypedUseSelectorHook, useSelector } from 'react-redux';
import { RootState } from 'models//store';

export const useSelectorTyped: TypedUseSelectorHook<RootState> = useSelector;
