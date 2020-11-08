import {StocksState} from '../../../types/StocksState';
import {StocksAction} from '../../../types/StocksAction';
import { SET_STOCKS } from '../../utils/constants';

export function modelReducer(
    state: StocksState,
    action: StocksAction
):  StocksState {

    switch(action.type) {
        case SET_STOCKS: 
        return {
            ...state,
            stocks: action.stocks
        }
    }
}