// Webpack uses root project build directory
config.resolve.modules.push("../site/build/processedResources/Js/main");

config.module.rules.push({
    test: /\.css$/,
    loader: 'style-loader!css-loader'
});
