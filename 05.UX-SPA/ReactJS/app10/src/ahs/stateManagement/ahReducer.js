import AccountHolder from '../models/AccountHolder';
import AHService from '../services/AHService';

export const WAIT = "wait";
export const ERR = "error";
export const LOAD_AHS = "load account holders";
export const MARK_EDIT_AH = "mark account holder editable";
export const UNMARK_EDIT_AH = "unmark account holder editable";

export const createWaitAction = () => ({ type: WAIT });
export const createErrAction = errMsg => ({ type: ERR, errMsg });
export const createLoadAhsAction = ahs => ({ type: LOAD_AHS, ahs });
export const createMarkEditAhAction = id => ({ type: MARK_EDIT_AH, id });
export const createUnMarkEditAhAction = id => ({ type: UNMARK_EDIT_AH, id });

export const createLoadAhsActionThunk = () => dispatch => {
    dispatch(createWaitAction());
    AHService.getAllAccounts()
        .then(resp => dispatch(createLoadAhsAction(resp.data)))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to laod! Please retry later!")) })
}

export const createAddAhActionThunk = ah => dispatch => {
    dispatch(createWaitAction());
    AHService.addAccount(ah)
        .then(resp => createLoadAhsActionThunk()(dispatch))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to save! Please retry later!")) })
}

export const createUpdateAhActionThunk = ah => dispatch => {
    dispatch(createWaitAction());
    AHService.updateAccount(ah)
        .then(resp => createLoadAhsActionThunk()(dispatch))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to save! Please retry later!")) })
}


const initState = () => ({
    ahs: null,
    shallWait: false,
    errMsg: null
});

const ahReducer = (oldState = initState(), action) => {
    let modifiedState = null;

    switch (action.type) {
        case WAIT:
            modifiedState = { ...oldState, shallWait: true, errMsg: null };
            break;
        case ERR:
            modifiedState = { ...oldState, errMsg: action.errMsg, shallWait: false };
            break;
        case LOAD_AHS:
            modifiedState = { ...oldState, errMsg: null, shallWait: false,ahs:action.ahs };
            break;
        case MARK_EDIT_AH:
            modifiedState = { ...oldState, ahs: oldState.ahs.map(a => a.ahId != action.id ? a : { ...a, isEditable: true }) };
            break;
        case UNMARK_EDIT_AH:
            modifiedState = { ...oldState, ahs: oldState.ahs.map(a => a.ahId != action.id ? a : { ...a, isEditable: undefined }) };
            break;
        default:
            modifiedState = oldState;
            break;
    }

    return modifiedState;
}

export default ahReducer;