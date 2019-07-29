import React, {Component} from 'react';
import Tehtava from "./Tehtava";
import '../css/TehtavaList.css';

class TehtavaList extends Component {
    render() {
        var self = this;

        var kaikki = this.props.tehtavat
            .sort(function (s1, s2) {
                return s2.id - s1.id;
            })
            .map(function(tehtava) {
                return (<Tehtava tehtava={tehtava} poista={self.props.poisto} key={tehtava.id}/>);
            });
        return(
            <div>
                <ul className="tehtavalist">
                    {kaikki}
                </ul>
            </div>
        );
    }
}

export default TehtavaList;