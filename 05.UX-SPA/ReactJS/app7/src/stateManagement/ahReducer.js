import AccountHolder from '../models/AccountHolder';

export const ADD_AH = "add account holder";
export const UPDATE_AH = "update account holder";
export const DELETE_AH = "delete account holder";
export const MARK_EDIT_AH = "mark account holder editable";
export const UNMARK_EDIT_AH = "unmark account holder editable";

export const createAddAhAction = ah => ({ type: ADD_AH, ah });
export const createUpdateAhAction = ah => ({ type: UPDATE_AH, ah });
export const createDeleteAhAction = id => ({ type: DELETE_AH, id });
export const createMarkEditAhAction = id => ({ type: MARK_EDIT_AH, id });
export const createUnMarkEditAhAction = id => ({ type: UNMARK_EDIT_AH, id });

const initState = () => ({
    ahs: [
        new AccountHolder(101, "Vamsy Kiran", "9052224753", "vamsy@gmail.com", 0),
        new AccountHolder(102, "Srinivas", "7777777788", "srinu@gmail.com", 0),
        new AccountHolder(103, "Abhishek", "8888889988", "abhi@gmail.com", 0)
    ]
});

const ahReducer = (oldState = initState(), action) => {
    let modifiedState = null;

    switch (action.type) {
        case ADD_AH:
            modifiedState = { ...oldState, ahs: [...oldState.ahs, action.ah] };
            break;
        case UPDATE_AH:
            modifiedState = { ...oldState, ahs: oldState.ahs.map(a => a.ahId != action.ah.ahId ? a : {...action.ah,isEditable:undefined}) };
            break;
        case DELETE_AH:
            modifiedState = { ...oldState, ahs: oldState.ahs.filter(a => a.ahId != action.id) };
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