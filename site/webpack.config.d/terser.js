const TerserPlugin = require('terser-webpack-plugin');

config.optimization = {
    minimizer: [
        new TerserPlugin(
            {
                sourceMap: config.devServer !== undefined, // Must be set to true if using source-maps in production
                terserOptions: {
                    // https://github.com/webpack-contrib/terser-webpack-plugin#terseroptions
                    keep_classnames: true,
                    keep_fnames: true,
                    sourceMap: config.devServer !== undefined,
                }
            }
        ),
    ],
};
