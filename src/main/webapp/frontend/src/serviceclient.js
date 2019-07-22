import axios from 'axios';
const apiUrl = "http://localhost:8080/api/todot"

export function haeTehtavat(){
    return axios.get(apiUrl);
}
export function uusiTehtava(tehtava) {
    return axios.post(apiUrl, tehtava);
}
export function poistaTehtava(id){
    return axios.delete(apiUrl + "/" + id);
}
// export function muokkaaTehtavaa(id, tehtava) {
//     return axios.put(apiUrl + "/" + id, tehtava);
// }