const TerserPlugin = require('terser-webpack-plugin');

config.optimization = {
    minimizer: [
        new TerserPlugin(
            {
                terserOptions: {
                    // https://github.com/webpack-contrib/terser-webpack-plugin#terseroptions
                    keep_classnames: true,
                    keep_fnames: true,
                }
            }
        ),
    ],
};
