import React, {Component} from 'react';
import { haeTehtavat,uusiTehtava,poistaTehtava } from '../serviceclient.js';
import TehtavaList from "./TehtavaList";
import TehtavaForm from "./TehtavaForm";

class TehtavaBox extends Component {
    state = {
        tehtavat: []
    };
    componentDidMount() {
        this.haeTehtavatjaPaivita();
    }

    haeTehtavatjaPaivita = () => {
        haeTehtavat().then(res => {
            this.setState({tehtavat: res.data})
        });
    };
    poistaTehtava = (id)=> {
        poistaTehtava(id).then((res) => {
            this.haeTehtavatjaPaivita();
        });
    };
    uusiTehtava = (tehtava) => {
        uusiTehtava(tehtava).then((res) => {
            this.haeTehtavatjaPaivita();
        });
    };
    // muokkaaTehtavaa = (id, tehtava) => {
    //     muokkaaTehtavaa(id, tehtava).then((res) => {
    //         this.haeTehtavatjaPaivita();
    //     });
    // };
    render() {
        return (
            <div>
                <h1 className="pääotsikko">Todo-Lista</h1>
                <TehtavaList tehtavat={this.state.tehtavat} poisto={this.poistaTehtava}/>
                <TehtavaForm lisaaTehtava={this.uusiTehtava}/>
            </div>
        );
    }
}

export default TehtavaBox;