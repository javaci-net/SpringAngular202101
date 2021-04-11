export interface IAuthResult{
    principal:{
        username:string,
        authorities:Array<{key:string, value:string}>,
        accountNonExpired:boolean,
        accountNonLocked:boolean,
        credentialsNonExpired:boolean,
        enabled:boolean,
    },
    authenticated:boolean
}
export interface ILoginResponse {
    authResult?:IAuthResult,
    jwtToken?:string
}
