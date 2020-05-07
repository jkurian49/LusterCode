import Post from './components/Post';
import {Component} from "react";

class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <div>
                    <Post />
                </div>
            </div>
        )
    };
}
export default App;