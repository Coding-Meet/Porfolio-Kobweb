// Kotlin/JS IR emits the whole app as one module, which doesn't play well with webpack's production defaults.
// Using TerserPlugin with swcMinify speeds up build times dramatically.

;(function () {
    if (config.mode !== 'production') return;
    try {
        const TerserPlugin = require('terser-webpack-plugin');
        config.optimization = config.optimization || {};
        config.optimization.minimizer = [
            new TerserPlugin({
                extractComments: false,
                minify: TerserPlugin.swcMinify,
                terserOptions: {
                    compress: true,
                    format: { comments: false },
                    mangle: true,
                },
            }),
        ];
    } catch (e) {
        // Fallback to default minifier if swc/terser plugin is not loaded
    }
})();
