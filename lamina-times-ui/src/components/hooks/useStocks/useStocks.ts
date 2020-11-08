import { useReducer } from 'react';
import {StockScheme } from '../../types/StockScheme';
import { modelReducer } from './reducer/reducer';
import {getInitialState } from '../utils/getInitialState'

const initialState = getInitialState();
export function useStocks():  StockScheme {
    const [state, dispatch] = useReducer(modelReducer, initialState);
    return {
        ...state,
        fetchStocks() {

        }
    }
}