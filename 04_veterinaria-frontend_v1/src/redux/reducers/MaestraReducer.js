const initialState = {
  loadingList: false,
  loadingCrud: false,
  maestra: {},
  editOk: false,
  addOk: false,
  deleteOk: false,
  maestraList: [],
  messageCrud: null,

};

export const MaestraReducer = (state = initialState, action) => {
  switch (action.type) {
    case "GET_MAESTRAS_START":
      return {
        ...state,
        loadingList: true,
      };

    case "GET_MAESTRAS_SUCCESS":
      return {
        ...state,
        maestraList: action.data,
      };

    case "GET_MAESTRAS_FAIL":
      return {
        ...state,
        maestraList: null,
        messageCrud: {
          code: action.error,
          message: action.message,
        },
      };
    case "GET_MAESTRAS_FINISH":
      return {
        ...state,
        loadingList: false,
      };

    case "GET_MAESTRA_START":
      return {
        ...state,
        loadingCrud: true,
      };

    case "GET_MAESTRA_SUCCESS":
      return {
        ...state,
        maestra: action.data,
      };

    case "GET_MAESTRA_FAIL":
      return {
        ...state,
        maestraList: null,
        messageCrud: {
          code: action.error,
          message: action.message,
        },
      };
    case "GET_MAESTRA_FINISH":
      return {
        ...state,
        loadingCrud: false,
      };

    case "DELETE_MAESTRA_START":
      return {
        ...state,
        loadingCrud: true,
      };

    case "DELETE_MAESTRA_SUCCESS":
      return {
        ...state,
        addOk: false,
        editOk: false,
        deleteOk: true,
        maestraList: action.data,
      };
    case "DELETE_MAESTRA_FAIL":
      return {
        ...state,
        messageCrud: {
          code: action.error,
          message: action.message,
        },
      };
    case "DELETE_MAESTRA_FINISH":
      return {
        ...state,
        loadingCrud: false,
      };
    case "ADD_MAESTRA_START":
      return {
        ...state,

        loadingCrud: true,
      };
    case "ADD_MAESTRA_SUCCESS":
      return {
        ...state,

        addOk: action.data,
        editOk: false,
        deleteOk: false,
        messageCrud: {
          code: "success",
          message: "Elemento Creado Correctamente",
        },
      };
    case "ADD_MAESTRA_FAIL":
      return {
        ...state,
        messageCrud: {
          code: action.error,
          message: action.message,
        },
      };
    case "ADD_MAESTRA_FINISH":
      return {
        ...state,

        loadingCrud: false,
      };

    case "EDIT_MAESTRA_START":
      return {
        ...state,
        loadingCrud: true,
      };
    case "EDIT_MAESTRA_SUCCESS":
      return {
        ...state,
        addOk: false,
        editOk: action.data,
        deleteOk: false,
        messageCrud: {
          code: "success",
          message: "Elemento editado Correctamente",
        },
      };
    case "EDIT_MAESTRA_FAIL":
      return {
        ...state,
        messageCrud: {
          code: action.error,
          message: action.message,
        },
      };
    case "EDIT_MAESTRA_FINISH":
      return {
        ...state,
        loadingCrud: false,
      };
    case "CLEAR_MESSAGE_NOTIFICATION":
      return {
        ...state,
        messageCrud: null,
        // messageLogin: null,
      };





    default:
      return state;
  }
};
