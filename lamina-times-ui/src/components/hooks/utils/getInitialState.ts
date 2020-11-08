import {StocksState} from '../../types/StocksState';

export function getInitialState(): StocksState {

    return {
        stocks: [],
        inputErrorMessage: '',
        isLoading: false,
        error: null
    };
}