import React, { Component } from "react";
import "./Post.css";
class Post extends Component {
    render() {
        return <article className="Post" ref="Post">
            <header>
                <div className="Post-user">
                    <span>Jason</span>
                </div>
            </header>
            <div className="Post-question">
                <span>How do I code a React JS app?</span>
            </div>
            </article>
    }

}
export default Post;