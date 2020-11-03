config.output.publicPath = "/kotlin-react-bootstrap/";

if (config.devServer !== undefined) {
    config.devServer.openPage = "kotlin-react-bootstrap/";
    config.devServer.historyApiFallback = true;
    config.devServer.hot = true;
}
