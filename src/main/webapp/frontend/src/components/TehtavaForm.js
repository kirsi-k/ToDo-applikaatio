import React, {Component} from 'react';

class TehtavaForm extends Component {
    state = {teksti: ''};
    textChange = (e) => {
        this.setState({teksti: e.target.value});
    };
    laheta = (e) => {
        e.preventDefault();
        this.props.lisaaTehtava(this.state);
        this.setState({teksti: ''});
    };
    render() {
        return (
            <div>
                <form className="tehtavaform" onSubmit={this.laheta}>
                    <table>
                        <tbody>
                        <tr><td>Kirjoita tähän uusi tehtävä:</td><td><input value={this.state.teksti} onChange={this.textChange}/></td>
                        <td></td><td><input type="submit" value="Lisää"/></td></tr>
                        </tbody>
                    </table>
                </form>
            </div>
        );
    }
}

export default TehtavaForm;