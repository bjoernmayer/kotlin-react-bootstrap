// Webpack uses root project build directory
config.resolve.modules.push("../site/build/processedResources/Js/main");

config.module.rules.push({
    test: /\.css$/,
    loader: 'style-loader!css-loader'
});

config.module.rules.push({
    test: /\.(png|svg|jpg|gif)$/,
    loader: 'file-loader',
    options: {
        name: '[name].[ext]',
    },
});
