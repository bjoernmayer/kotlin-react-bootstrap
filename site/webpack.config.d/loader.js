// Webpack uses root project build directory
config.resolve.modules.push("../site/build/processedResources/js/main");

config.module.rules.push({
    test: /\.(png|svg|jpg|gif|ico)$/,
    loader: 'file-loader',
    options: {
        name: '[name].[ext]',
    },
});
