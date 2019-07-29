import React, {Component} from 'react';
import '../css/Tehtava.css';

class Tehtava extends Component {
    poista = () => {
        this.props.poista(this.props.tehtava.id);
    };
    render() {
        return (
            <li>
                <div className="tehtava">
                    <p className="teksti">{this.props.tehtava.teksti}</p>
                    <p>
                        <button className="button" type="button" onClick={this.poista}>Poista</button>
                    </p>
                </div>
            </li>
        );
    }
}

export default Tehtava;