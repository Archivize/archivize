import { Box, VStack, HStack } from '../elements/LayoutPrimitives'
import { OmnivoreNameLogo } from '../elements/images/OmnivoreNameLogo'
import { theme } from '../tokens/stitches.config'
import { GoogleReCaptchaProvider } from '@google-recaptcha/react'

type ProfileLayoutProps = {
  logoDestination?: string
  children: React.ReactNode
}

export function AuthLayout(props: ProfileLayoutProps): JSX.Element {
  return (
    <>
      <VStack
        alignment="center"
        distribution="center"
        css={{
          // bg: '$omnivoreYellow',
          height: '100vh',
          bg: '$omnivoreYellow',
        }}
      >
        {props.children}
      </VStack>

      <Box
        css={{
          position: 'absolute',
          top: 0,
          left: 0,
          m: '0',
          width: '100%',
        }}
      >
        <HStack
          alignment="center"
          distribution="between"
          css={{
            mt: '18px',
            ml: '18px',
            mr: '0',
            '@smDown': {
              ml: '8px',
              mt: '10px',
            },
          }}
        >
          <OmnivoreNameLogo
            color={theme.colors.omnivoreGray.toString()}
            href={props.logoDestination ?? '/login'}
          />
        </HStack>
      </Box>
    </>
  )
}
